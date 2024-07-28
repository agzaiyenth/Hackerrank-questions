#include <iostream>
#include <cstring>
#include <cmath>
#include <vector>

using namespace std;

int N,K;
int v[310],match[310],inv[310];
vector<int> adj[310];
bool vis[310];

bool augment(int x)
{
	if(vis[x])return false;
	vis[x] = true;
	for(int i = 0; i < adj[x].size(); i++)
	{
		if((inv[adj[x][i]] == -1 || augment(inv[adj[x][i]])))
		{
			match[x] = adj[x][i];
			inv[adj[x][i]] = x;
			return true;
		}
	}
	return false;
}

int main()
{
	int T;
	cin >> T;
	for(int t = 0; t < T; t++)
	{
		cin >> N >> K;
		for(int i = 0; i < N; i++)
		{
			adj[i].clear();
			cin >> v[i];
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = i+1; j < N; j++)
			{
				if(abs(v[i]-v[j]) >= K)
				{
					adj[i].push_back(j);
				}
			}
		}
		memset(match,-1,sizeof(match));
		memset(inv,-1,sizeof(inv));
		int ans = 0;
		for(int i = 0; i < N; i++)
		{
			if(match[i] == -1)
			{
				memset(vis,false,sizeof(vis));
				augment(i);
			}
		}
		for(int i = 0; i < N; i++)
		{
			if(inv[i] == -1)ans++;
		}
		cout << ans << endl;
	}
	return 0;
}
