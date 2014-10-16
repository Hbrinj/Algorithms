#include <stdio.h>

int occurance(int a[], int c, int x, bool side)
{
	int low = 0, high = c-1;
	int place = c;
	int mid;
	while( low <= high)
	{
		mid = (low + high)/2;

		if(a[mid] == x)
		{
			if(side) low = mid+1;
			else high = mid-1;

			place = mid;

		}

		if(a[mid] > x) high = mid-1;
		if(a[mid] < x) low = mid+1;
	}

	return place;
}

int main()
{
	int x;
	int a[] = {1,2,2,2,2,5,5,5,5,5,7,7,7,7,8,8,8,8};
	printf("please enter a number to search for\n");
	scanf("%d", &x);
	int low = occurance(a,sizeof(a)/sizeof(a[0]),x,false);
	if(low == (sizeof(a)/sizeof(a[0])))
	{
		printf("%d occured 0 times\n",x);
	}
	else
	{
		int high = occurance(a,sizeof(a)/sizeof(a[0]),x,true);
		printf("%d occured %d times\n",x,(high-low)+1);
	}
}