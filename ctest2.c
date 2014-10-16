#include <stdio.h>
#define BASE 10

void printArray(int*);
void radixsort(int*, int);

int main (int argc, char** argv)
{
	int a[] = {1,3,5,1,239,50};
	int c = (sizeof(a))/sizeof(a[0]);
	printf("%d\n", *a);
	printArray(a);
	radixsort(a,c);
	printArray(a);
}

void printArray(int* a)
{
	while(*a != '\0')
	{
		printf("%d ",*a);
		a++;
	}
}

void radixsort(int* a, int c)
{
	int b[c];
	int m = a[0];
	int i;
	int ex = 1;

	for(i = 0; i < c; i++)
	{
		if(m < a[i])
			m = a[i];
	}

	while(m / ex > 0)
	{
		int bucket[BASE] = {0};

		for(i = 0; i < c; i++)
		{
			bucket[(a[i] / ex) % BASE]++;
		}

		for(i = 1; i < BASE; i++)
		{
			bucket[i] += bucket[i-1];
		}

		for(i = c-1; i >=0; i--)
			b[--bucket[(a[i]/ex) % BASE]] = a[i];

		for(i = 0; i < c; i++)
		{
			a[i] = b[i];
		}

		ex*= BASE;
	}
}