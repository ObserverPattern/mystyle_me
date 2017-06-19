#include <stdio.h>
#define INF 987654321

int main()
{
	
	int sugar;
	int answer = INF;
	int multi = 0;
	scanf("%d", &sugar);

	while (1)
	{
		int res;
		if (multi == 0) res = sugar;
		else res = sugar - (5 * multi);
		
		if (res % 3 == 0)
		{
			answer = answer > multi + res / 3 ? multi + res / 3 : answer;
		}

		multi++;
		if (5 * multi > sugar)
		{
			if(answer == INF) answer = -1;
			break;
		}
	}

	printf("%d\n", answer);

	return 0;
}