//import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;



public class HachageCollision<T extends NoeudAbstrait> extends Hachage <T> {
		int a ;	
		LinkedList<T> tab[];
		
		@SuppressWarnings("unchecked")
		public HachageCollision(int m,int a){
			super(m);
			this.a=a;
			tab=new LinkedList [m];//tableau de listes chainees de taille m 
			
			for (int i=0;i<m;i++)
			{
				tab[i]=new LinkedList<T> ();
			}
		}
		
		public int EquivalentNumerique(String s){
			//la fonction appelee par h renvoyant l'equivaleent numerique d'une chaine 
			//donnee
			int x=0;
			for (int i=0;i<s.length();i++)
				x+=Math.pow(a, i)*s.charAt(i);
			return x;
		}
		
		public String getListsSize(){
			//creation d'une HashMap
			//ayant comme clee la taille de chaque liste
			//et en valeur l'occurence de chaque taille 
			HashMap<Integer,Integer> H=new HashMap<Integer,Integer>();
			int k;String res="";int a =0;

			for (int i=0;i<m;i++){
		
					k=tab[i].size();
					if(H.containsKey(k)){
					
					H.put(k, H.get(k) + 1);
					}
					else 
						H.put(k,1);
				
				
				
				}
				

for (Integer key : H.keySet()) {
	res+=H.get(key);
	res+=" entrée(s) contenant ";
	res+=key;
	res+=" élément(s)\n";
}
			return res;
			}
		
		
		
		public void display(){
			
			for(int i=0; i<m; i++)
		      {
			for(int num=0; num<tab[i].size(); num++)
		      {
				System.out.print(tab[i].get(num).cle()+" ");
			  }
			System.out.println();

		      }
		
		}
		
	@Override
		 public void add(T o){
			int hach=this.h(o);
			if(!this.recherche(o))//si o n'est pas dans la table
			 {
				tab[hach].add(o);//onl'insere dans la chaine dediee
								//avec la fonction add de la classe util.LinkedList
			}
			
		 }
	 @Override
public Boolean recherche(T d){
		 long startTime = System.nanoTime();
		 int i=0;
			for (T o: tab[h(d)]){//parcourir la liste des chaine ayan le hashcode egale
								//a celui de la chaine qu'on cherche
				i++;
			if (o.cle().equals(d.cle()))
			{	
				long sT = System.nanoTime(); //stop time
				Statistiques.tempexecution.put(d.cle(),(int) ((sT-startTime)) );
				Statistiques.nbcomptrouve.put(d.cle(),i );
				return true;
		
			}
			}
			long sT2 = System.nanoTime();
			Statistiques.tempexecution.put(d.cle(),(int) ((sT2-startTime)) );
			Statistiques.nbcomppastrouve.put(d.cle(),i );
		return false;
	 }


	
	@Override
		 public  int h(T d){
				return (this.EquivalentNumerique(d.cle()))%m;//retour de l'equivalent numerique
			}
	public static void main(String[] args){
	

	}
}
