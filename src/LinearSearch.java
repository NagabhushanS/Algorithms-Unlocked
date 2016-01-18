
public class LinearSearch {

	public static void main(String[] args) {
		int a[] = new int[10];
		for(int i=0; i<10; i++){
			a[i] = i;
		}
		int x = 2;
		int pos=-1;
		for(int i=0; i<10; i++){
			if (a[i]==x){
				pos = i;
				break;
			}
		}
		if (pos==-1){
			System.out.println("Item not found!");
		} else{
			System.out.printf("Item found at %d position", pos);
		}

	}

}
