//tableau normal
//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.reflect.Array;




public class HachageLineaire <T extends NoeudAbstrait> extends Hachage <T> {
		 T[] tab;   

		  
		 static int R;
		@SuppressWarnings("unchecked")
		public HachageLineaire(int m){
			super(m);
			tab = newArray(m);
			R=m;
			
		}
		@SafeVarargs
		static <T> T[] newArray(int length, T... array)
		{
		    return Arrays.copyOf(array, length);
		}
		@Override	
	    public void add(T o) 

	    {              

	        int tmp = h(o);
	        int i = tmp;
	        do
	        {
	            if (tab[i] == null)//si emplacement vide

	            {
	                tab[i] = o;//inserer


	                return;
	            }
	            if (tab[i].equals(o.cle())) //si la chaine se trouve dans la table

	            { 
	                return; //arreter la fonction 
	            }            
	            i = (i + 1) % m;  //incrementer le compteur sans depasser la taille 

	        } while (i != tmp);     

	    }
	

		public String toString(){
			String s="",a="";
			
			if (this.isEmpty())
			 return "";
			else {
				
				for (int i=0;i<m;i++){
					//parcourir la table
					if (this.tab[i]!=null){
						//si element pas vide
						a=tab[i].cle();
						//stocker dans a 
						s+=i+" : "+a.substring(0,a.length())+"\n";//CONCATENER	
				
					}
					
					}
				return s;
			}
			
			
			
		}
		
		//verifie si le tableau est plein ou pas 

		public Boolean isFull(){
			for (int i=0;i<m;i++){
				if (this.tab[i]==null){
					return false;
				}
			}
			return true;
			
		}
		//verifie si le tableau est vide ou pas 
		public Boolean isEmpty(){
			for (int i=0;i<m;i++){
				if (this.tab[i]!=null){
					return false;
				}
			}
			return true;
			
		}
		
		
		public Boolean vide(){
			for (int i=0;i<m;i++)
			{	
				if (tab[i]!=null)
					return false;
				}
			
			return true;
		}

	
	//la fonction recherche
		@Override
		 public Boolean recherche(T d){
			 for(int i=0; i<m; i++)
	      { 
			if( this.tab[i]!=null &&this.tab[i].cle()==d.cle())
				return true;
				}
			
		return false;
				 }
	
		public int hashcode(String s){
		
			return s.hashCode()%m;
		}
	
	@Override
		 public  int h(T d){
		 
			return Math.abs(this.hashcode(d.cle()));

	}
	public static void main(String[] args){
		


	}
}
