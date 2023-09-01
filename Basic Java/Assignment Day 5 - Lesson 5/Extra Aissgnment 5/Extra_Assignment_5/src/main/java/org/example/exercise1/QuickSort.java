package org.example.exercise1;

public class QuickSort extends SequenceNumber implements Sort {
    public QuickSort(int n) {
        super(n);
    }
    @Override
    public void sort(int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int pivot = this.getList()[(i + j) / 2];
        do{
            while ( this.getList()[i] < pivot )
                i++;
            while ( this.getList()[j] > pivot )
                j--;
            if (i <= j){
                int temp = this.getList()[i];
                this.getList()[i] = this.getList()[j];
                this.getList()[j] = temp;
                i++;
                j--;
            }
        }while (i < j);

        if (i < right)
            sort(i, right);
        if (left < j)
            sort(left, j);

    }
}
