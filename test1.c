#include <stdio.h>
#define SWAP(a,b) do{int t = a; a = b, b = t;}while(0)
#define IS_LESS(a,b) (a<b)
#define BASE 10

void printArray(int*,int);
void siftdown(int*, int, int);
void heapsort(int*,int);
void insertionsort(int*, int);
void radixsort(int*, int);

struct Queue{
	int head;
	int tail;
	bool flip;
	int Q[BASE];
};
void enqueue(Queue*, int);
int dequeue(Queue*);

struct Stack{
	int top;
	int St[BASE];
};
void push(Stack *, int);
int pop(Stack*);




int main(int argc, char** argv)
{
	int a[] = {2,8,2,1,0,30,};
	int c = (sizeof(a)) / sizeof(a[0]);
	printArray(a,c);
	
	radixsort(a,c);
	printArray(a,c);
	Stack st  = {0};
	push(&st,1);
	push(&st,2);
	push(&st,3);
	push(&st,4);
	push(&st,5);
	push(&st,6);
	push(&st,7);
	push(&st,8);
	push(&st,9);
	push(&st,10);
	push(&st,1);
	push(&st,1);

	return 0;
}

void enqueue(Queue* Q, int x)
{
	if(Q->flip)
	{
		if(Q->tail < Q->head)
		{
			Q->Q[Q->tail] = x;
			Q->tail++;
		} else {
			printf("QUEUE FULL\n");
		}
	} else {
		Q->Q[Q->tail] = x;
		//printf("%d\n", Q->Q[Q->tail]);
		Q->tail++;
		if(Q->tail > BASE -1)
		{
			Q->tail = 0;
			Q->flip = !Q->flip;
		}
	}
}

int dequeue(Queue* Q)
{
	if(Q->flip)
	{

		if(Q->head >= Q->tail)
		{
			int x = Q->Q[Q->head];
			Q->head++;
			if(Q->head > BASE-1)
			{
				Q->head = 0;
				Q->flip = !Q->flip;
			}
			return x;
		}
	} else {
		int x = Q->Q[Q->head];
		Q->head++;
		if(Q->head > BASE-1)
		{
			Q->head = 0;
			Q->flip = !Q->flip;
		}
		return x;
	}
	return 0;
}


void push(Stack * st, int x)
{
	if(!(st->top == BASE))
	{
		st->St[st->top] = x;
		st->top++;
	}else{
		printf("STACK FULL\n");
	}
}

void printArray(int* a, int c)
{
	for(int i = 0; i < c; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}

void insertionsort(int* a, int c)
{
	int d = 0;
	for(int i = 1; i < c; i++)
	{
		d = i;
		int temp = a[i];
		while(d > 0 && a[d-1] < temp )
		{
			a[d] = a[d-1];
			d--;
		}
		a[d] = temp;
	}
}

void siftdown(int* a, int s, int e)
{
	int root = s;

	while(root*2+1 < e)
	{
		int child = root*2+1;
		if(child+1 < e && IS_LESS(a[child],a[child+1]))
		{
			child++;
		}

		if(IS_LESS(a[root],a[child]))
		{
			SWAP(a[root],a[child]);
			root= child;
		} else {
			return;
		}
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
		SWAP(a[0],a[end]);
		siftdown(a,0,end);
	}
}

void radixsort(int* a, int c)
{
	int b[c];
	int m = a[0];
	int ex = 1;
	int i;

	for(i = 0; i < c; i++)
	{
		if(m < a[i])
			m = a[i];
	}

	while(m / ex > 0)
	{
		int bucket[BASE] = {0};

		for(i = 0; i < c; i++)
			bucket[(a[i]/ex) % BASE]++;

		for(i = 1; i < BASE; i++ )
			bucket[i] += bucket[i-1];

		for(i = c-1; i >= 0; i--)
			b[--bucket[(a[i] / ex) % BASE]] = a[i];

		for(i = 0; i < c; i++)
			a[i] = b[i];

		ex *= BASE;

	}

}