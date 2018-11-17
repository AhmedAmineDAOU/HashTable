
public abstract class Hachage<T extends NoeudAbstrait> {
	
				int m ;//nombre maximal d'entree
					//sur la table
			//	T tab[];
				
				
				
				public Hachage (int a){
					m=a;
				};
	
		
				abstract public void add(T o);
					
				
				abstract Boolean recherche(T d);
					
				
				abstract public  int h(T d);
					
					
				




}				
				//collisions par chaı̂nage
				/*Le principe de cette résolution est de placer dans une liste chaı̂née tous
				les éléments de même valeur de hachage. Si T représente le tableau où les
				éléments sont rangés, T est un tableau de listes chaı̂nées.
				L’insertion de x consiste à rajouter x dans la liste T [h(x.cle)]. De même,
				x sera recherché ou supprimé dans la même liste.*/


				/*Hachage coalescent
				La gestion des collisions dans le hachage coalescent consiste à subdiviser
				le tableau en deux zones :
				– une zone d’adresses dites primaires de capacité p,
				– une zone dite de réserve de capacité r.
				où p + r = m est la taille du tableau T où les éléments seront rangés.
				2La zone de réserve correspond à r emplacements contigus du bas du
				tableau. Les éléments en collision sont alors rangés dans cette zone en al-
				lant de bas en haut.*/