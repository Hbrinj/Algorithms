#include <stdio.h>
#include <string.h>

void printArray(int*, int);
void insertionSort(int*, int);
void bubbleSort(int*, int);
void Heapsort(int*, int);
void SiftDown(int*,int,int);
void selectionsort(int* ,int);
int sorted(int[], int);
int mergeArrays(int*,int,int*,int,int);
void mergesort(int*, int);
void mergesort1(int*,int,int);
void merge(int*,int,int,int);
int binarysearch(int*,int,int);

#define IS_LESS(a, b) (a < b)
#define SWAP(a,b) do{int t = a; a = b; b =t;} while(0)

int main(int argc,char** argv)
{
	int a[] = {1,12,6,4,2,8,0,0,0,0,0,0,0};
	int a2[] = {10,2,166,4,1,8,170,200,9,40,12,6000,57,84,25};
	int c = 6;
	int real = (sizeof(a))/sizeof(a[0]);
	int c2 = sizeof(a2) / sizeof(a2[0]);
	//Heapsort(a,c);
	Heapsort(a2,c2);
	//mergesort(a2,c2);
	//printArray(a,c);
	printArray(a2,c2);
	//mergeArrays(a,c,a2,c2,real);
	//printArray(a,real);
	return -1;
}

void printArray(int* a, int c)
{
	for(int i = 0; i < c; i++)
	{
		printf(" %d ",a[i]);
	}
	printf("\n");
}

void insertionSort(int a[], int c)
{
	int d = 0;
	for(int i = 1; i < c; i++)
	{
		d = i;
		while(d > 0 && a[d] < a[d-1])
		{
			SWAP(a[d],a[d-1]);
			d--;
		}
	}
}

void bubbleSort (int* a, int c)
{
	for(int i = c-1; i > 0; i --)
	{
		for (int j = 0; j < i; j++)
		{
			if (a[j] > a[j+1])
			{
				SWAP(a[j],a[j+1]);
			}
		}
	}
}

void selectionsort (int* a, int c)
{
	int i,j;
	for(i = c-1; i > 0; i--){
		int posGreat = 0;
		for(j = 0; j <= i; j++)
		{
			if(IS_LESS(a[posGreat],a[j]))
				posGreat = j;
		}

		if(i != posGreat)
		{
			SWAP(a[i],a[posGreat]);
		}
	}
}


void Heapsort (int* a, int c)
{
	int start,end;
	for (start = (c -2) / 2; start >= 0; start --)
	{
		SiftDown(a,start,c);
	}

	for(end = c-1; end > 0; end--)
	{
		SWAP(a[end], a[0]);
		SiftDown(a,0,end);
	}
}


void SiftDown(int* a, int start, int end)
{
	int root = start;
	while(root*2+1 < end)
	{
		int child = 2*root+1;
		if ((child+1 < end) && IS_LESS(a[child], a[child+1]))
		{
			child++;
		}

		if(IS_LESS(a[root],a[child]))
		{
			SWAP(a[root],a[child]);
			root = child;
		} else {
			return;
		}
	}
}

void mergesort(int* a, int c)
{
	int m = ((c % 2 == 1) ? (c - 1) / 2 : c /2);
	mergesort1(a,0,m-1);
	mergesort1(a,m,c-1);
	printArray(a,c);
	merge(a,0,m,c);

}

void mergesort1(int* a, int ls,int le)
{
	if((le-ls) <= 1)
		return;

	int m = (((le-ls) % 2 == 1) ? ((le-ls - 1) / 2) + ls : ((le-ls) /2)+ls);
	mergesort1(a,ls,m-1);
	mergesort1(a,m,le);
	merge(a,ls,m,le);
}

void merge(int* a, int ls, int m, int re)
{
	int d = 0;
	for(int i = (ls+1); i <re; i++)
	{
		d = i;
		int temp = a[d];
		while(d > ls && IS_LESS(temp,a[d-1]))
		{
			a[d] = a[d-1];
			d--;
		}
		a[d] = temp;
	}


}

// void SiftDown (int* a, int start, int end)
// {
// 	int root = start;
// 	while(root*2+1 < end) {
// 		int child = 2*root+1;
// 		if((child+1 < end) && IS_LESS(a[child], a[child+1])) {
// 			child++;
// 		}

// 		if(IS_LESS(a[root],a[child])) {
// 			SWAP(a[root],a[child]);
// 			root = child;
// 		} else {
// 			return
// 		}
// 	}
// }





int mergeArrays(int* a,int c1, int* b, int c2, int r)
{
	int realSizeofA = r;
	if(c1 + c2 > realSizeofA)
		return -1;

	int start = 0;
	for(int i = (realSizeofA - c1); i < realSizeofA; i ++)
	{
		a[i] = a[start];
		start++;
	}
	int end = (realSizeofA - c1);
	int bstart = 0;
	int astart = 0;
	while(bstart < c2 && end < realSizeofA)
	{
		if(b[bstart] < a[end])
		{
			a[astart] = b[bstart];
			astart++;
			bstart++;
		} 
		else if (b[bstart] > a[end])
		{
			a[astart] = a[end];
			astart++;
			end++;
		}
		else
		{
			a[astart] = a[end];
			astart++;
			a[astart] = b[bstart];
			astart++;
			bstart++;
			end++;
		}
	}

	if(bstart >= c2 && end < realSizeofA)
	{
		while(end < realSizeofA -1)
		{
			a[astart] = a[end];
			end++;
			astart++;
		}
	}

	if(bstart < c2 && end >= realSizeofA)
	{
		while(bstart < c2)
		{
			a[astart] = b[bstart];
			bstart++;
			astart++;
		}
	}

	return 1;

}

int binarysearch(int* a, int c, int target )
{
	int low = 0;
	int high  = c-1;

	while(low <= high)
	{
		int mid = (((low + high) % 2 ==1) ? ((low + high) -1) /2 : (low + high) / 2);
		if(target == a[mid])
			return mid;
		if(target > a[mid])
			low = mid +1;
		if (target < a[mid])
			high = mid-1;
	}
	return -1;
}









