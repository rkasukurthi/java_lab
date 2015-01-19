package sort.myImpl;

public class InsertSortAlgorithm implements SortAlgorithm{

	@Override
	public void sort(int[] a) {
		for (int j=1; j<a.length-1; j++){
			int key=a[j];
			int i=j-1;
			while(i>=0 && a[i]>key){
				a[i+1]=a[i];
				i=i-1;
			}
			a[i+1]=key;
		}
	}

}
