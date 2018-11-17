import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
class Statistiques {
	
	//classe de donnees statistiques
		public	static  HashMap<String,Integer>  tempexecution=new HashMap<String,Integer>();
		//cle mot //valeur temps d'execution de sa recherche
		public	static  HashMap<String,Integer> nbcomptrouve=new HashMap<String,Integer>();
		//cle mot //valeur nombre de comparaison avant de le trouver
		public	static  HashMap<String,Integer> nbcomppastrouve=new HashMap<String,Integer>();
		//cle mot //valeur nombre de comparaison avantde ne pas trouver 
		
}
public class Dictionnaire {
	static int nombredemotachercher=0;
	
		
			public static <T extends NoeudAbstrait> void VerifierDansDico(HachageCollision<StringDataa> hc) throws IOException{
				FileInputStream inputStream = null;
				 Scanner sc = null,input=null;
				 try {
					 //lecture du fichier dictionnaire
				     inputStream = new FileInputStream("francais.mots");
				     sc = new Scanner(inputStream, "UTF-8");
				     while (sc.hasNextLine()) {
				         String line = sc.nextLine();
				         line=line.replaceAll("[ ]","");
				         hc.tab[hc.EquivalentNumerique(line)%hc.m].addLast((new StringDataa(line)));

				     }
				 

				     if (sc.ioException() != null) {
				         throw sc.ioException();
				     }
				 } finally {
				     if (inputStream != null) {
				         inputStream.close();
				     }
				     if (sc != null) {
				         sc.close();
				     }
				 }
				
				 try {
					 //lecture de l'article l'equipe

					 File f=new File("ArticleLequipe.fr");
					 input = new Scanner(f);
				     while (input.hasNext()) {
				    
				         String line = input.next();
				      
			
				         hc.recherche(new StringDataa(line.replaceAll("[.,: ]","")));
				     }
				

				     if (input.ioException() != null) {
				         throw input.ioException();
				     }
				 } finally {
				     if (inputStream != null) {
				         inputStream.close();
				     }
					if (input != null) {
				         input.close();
				     }
				 }
						
				

			}
			
			
				@SuppressWarnings("rawtypes")
	public static void main(String []args) throws IOException{
					int sum=0,sum2=0,sum3=0;
					/******constructeur ***/
					HachageCollision hc =new HachageCollision(500,1);
					
					 
					VerifierDansDico(hc);
					for (int f : Statistiques.nbcomppastrouve.values()) {
					    sum += f;
					}
					System.out.println("nombre moyen de comparaisons pour déterminer qu’un mot n’existe \npas dans le dictionnaire");
					
					System.out.println(sum/Statistiques.nbcomppastrouve.size());
					
					
					System.out.println("le nombre moyen de comparaisons pour déterminer qu’un mot existe\npas dans le dictionnaire");
					for (int f : Statistiques.nbcomptrouve.values()) {
					    sum2 += f;
					}
					System.out.println(sum/Statistiques.nbcomptrouve.size());
					System.out.println("le nombre de comparaisons total "+sum2+sum); 
					
					for (int f : Statistiques.tempexecution.values()) {
						sum3+=f;
					}
					System.out.println("temps total d'execution des comparaisons "+sum3+" (nanosecondes) "+sum3/1000000000.0+" (secondes) ");
					
					System.out.println("temps moyen d'execution d'une seule recherche "+sum3/Statistiques.tempexecution.size()+" (nanosecondes) ");
				
					System.out.println("merci de changer les parametres dans le constructeur (main) pour avoir un resultat different");
					
				}
			
}

