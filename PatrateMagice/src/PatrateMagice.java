import java.util.Scanner;

public class PatrateMagice {
	private int[][] M;    // crearea matricii 
    private static int numarMatrice; // ordinul n al matricei 
    
    public PatrateMagice(int numar) // constructorul matricii patratului magic
    {
        this.numarMatrice=numar; // se initializeaza ordinul n cu cel introdus de la consola
        M=new int[numar][numar]; // cream matricea de ordin n introdus de la consola
    }
    
    public void crearePatratMagic() //metoda pentru crearea patratului magic
    {
    	if(numarMatrice%2==0) //se verifica daca ordinul n este impar
        {   
    		System.out.println("\nERROR : Ordinul trebuie sa fie impar"); //daca este par se va afisa o eroare
    		return; 
    		}
    	
        int rand=0; //initializam randurile
        int coloana=numarMatrice/2; // initializam coloana (pornim de la cea din centru)
        int n=1; // initializam contorul matricii
        while(n<=numarMatrice*numarMatrice) // cat timp contorul este mai mic ca ordinul la patrat se executa 
        {                                   // completarea patratului magic
            M[rand][coloana]=n++; // se porneste din centru completarea matricii
            rand--; coloana++; // se misca pe coltul din dreapta sus 
            if(rand<0 && coloana<=numarMatrice-1) // daca se afla deasupra indexului array-ului
            {                                   //se va decrementa randul si va fi mutat elementul pe ultimul rand
            	rand=numarMatrice-1;            // al coloanei curente
            	} 
            else if(coloana>numarMatrice-1 && rand>=0) // daca se scade din partea dreapta
            {                                     //elementul este mutat pe prima coloana a randului curent
            	coloana=0;  
            	} 
            else if(coloana>numarMatrice-1 && rand<0||M[rand][coloana]>0) // daca se afla in dreapta sus sau casuta e completata
            {   
            	rand+=2;    // va cobori doua casute si se va duce in stanga cu o casuta
            	coloana--; 
            	} 
        }
        afisarePatratMagic();
    }
    
    public void afisarePatratMagic()  // afisarea matricii patratului magic
    {
        System.out.print(" Patrat Magic:\n\n");
        for(int i=0;i<numarMatrice;i++)
        {   for(int j=0;j<numarMatrice;j++)
            {   printCalculareSpatii(M[i][j],numarMatrice*numarMatrice);  }
            System.out.println();
        }
    }
    
    
    public void insumareaNumerelorMatricii() // calcularea sumei elementelor matricii (pentru randuri si coloane)
    {
		for(int i = 0; i < numarMatrice; i++){
			int sumaElemente = 0;
			for(int j = 0; j < numarMatrice; j++){
				sumaElemente += M[i][j];
			}
			System.out.print(' ');
			System.out.print(sumaElemente);
		}

    }
    
    
    private void printCalculareSpatii(int numar,int maxim) // print care va calcula spatiile necesare in matrice
    {
        String x=new String()+numar; 
        String max=new String()+maxim;
        for(int i=0;i<=(max.length()-x.length());i++) System.out.print(" ");
        System.out.print(x);
    }
    
    private void stergereMatrice(){ // stergerea matricei
    	for(int i=0;i<numarMatrice;i++)
    	{
    		for(int j=0;j<numarMatrice;j++)
    		{
    			M[i][j]=0;
    			}
    		}
    	}
    
    
    public static void main(String args[])throws Exception
    {
    	// citirea ordinului n introdus de utilizator de la consola
        Scanner inserareMatrice=new Scanner(System.in); 
        System.out.print("Introduceti un numar impar pentru ordinul matricii: \n"); 
        numarMatrice=inserareMatrice.nextInt();
        
        //daca ordinul n este impar se va crea patratul magic de ordin n introdus de la ocnsola
        if(!(numarMatrice%2==0)) 
        {
        PatrateMagice patratMagicCreat=new PatrateMagice(numarMatrice);       
        patratMagicCreat.crearePatratMagic(); 
 
        // se afiseaza suma numerelor de pe coloane
        System.out.println("\nSuma pe coloane: ");
        patratMagicCreat.insumareaNumerelorMatricii();
        System.out.printf("\n");
        
        // se afiseaza suma numerelor de pe randuri
        System.out.println("\nSuma pe randuri: ");
        patratMagicCreat.insumareaNumerelorMatricii();    
          
        patratMagicCreat.stergereMatrice();  //stergerea matricii (pentru crearea unui nou patrat magic) 
        
        System.out.printf("\n");
       }
        else 
        	System.out.println("Ordinul matricii trebuie sa fie impar!"); //afisarea unei eroari daca se introduce un numar par
    }
}
