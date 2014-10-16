#include <stdio.h>

void printArray(int*,int);
void heapsort(int*,int);
void insertionsort(int*,int);
void selectionsort(int*,int);
void siftdown(int*,int,int);

#define SWAP(a,b) do{int t = a; a = b; b = t;}while(0)
#define IS_LESS(a,b) (a < b)

int main(int argc, char** argv)
{
	int a1[] = {0,4,1,2,5,12,-3};
	int c1 = (sizeof(a1))/sizeof(a1[0]);
	printf("heapsort \n Before");
	printArray(a1,c1);
	printf ("After\n");
	selectionsort(a1,c1);
	printArray(a1,c1);
}

void printArray(int* a, int c)
{
	printf("The array: ");
	for(int i = 0; i < c; i++)
	{
		printf(" %d ",a[i]);
	}
	printf("\n");
}

void bubblesort (int* a, int c)
{
	for(int i = c-1; i > 0; i--)
	{
		for (int j = 0; j < i; j++)
		{
			if(a[j] > a[j+1])
			{
				int t = a[j];
				a[j] = a[j+1];
				a[j+1]= t;
			}
		}
	}
}

void insertionsort (int* a, int c)
{
	int d =0;
	for(int i = 1; i < c; i++)
	{
		d = i;
		int temp = a[d];
		while(d > 0 && IS_LESS(temp,a[d-1]))
		{
			a[d] = a[d-1];
			d--;
		}
		a[d] = temp;
	}
}

void selectionsort (int* a, int c)
{
	for(int i = c-1; i > 0; i-- )
	{
		int posGreat = 0;

		for(int j = 0; j <= i; j++)
		{
			if(IS_LESS(a[posGreat],a[j]))
				posGreat = j;
		}

		if(posGreat != i)
			SWAP(a[i],a[posGreat]);
	}
}

void heapsort(int* a, int c)
{
	int start, end;

	for(start = (c-2)/2; start >= 0; start--)
	{
		siftdown(a,start,c);
	}

	for(end = c-1; end > 0; end--)
	{
		SWAP(a[end],a[0]);
		siftdown(a,0,end);
	}
}

void siftdown(int* a, int s, int e)
{
	int root = s;
	while(root*2+1 < e)
	{
		int child = root*2+1;
		if(child+1 < e && IS_LESS(a[child],a[child+1]))
			child++;

		if(IS_LESS(a[root],a[child]))
		{
			SWAP(a[root],a[child]);
			root = child;
		}
		else
			return;
	}
}

