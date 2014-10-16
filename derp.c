#include <stdio.h>
#include <stdlib.h>
void printbinary(int);

struct stack{
	int st[10];
	int head;
};

int main(int argc, char** argv)
{
	printbinary(atoi(argv[1]));
}

void printbinary(int a)
{
	stack st;
	st.head = 0;

	while(a > 0)
	{
		if(a % 2 == 1)
		{
			st.st[st.head] = 1;
			st.head++;
			a -= 1;
		}
		else
		{
			st.st[st.head] = 0;
			st.head++;
		}

		if(a > 1)
		{
			a = a/2;
		}
	}

	for(int i = st.head-1 ; i >=0 ; i --)
	{
		printf("%d",st.st[i]);
	}

	printf("\n");
}