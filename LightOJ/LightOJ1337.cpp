#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define P_B push_back
#define M_P make_pair
#define DBG(x) printf("%s %d\n", ffx, x)
#define SCI(x) scanf("%d",&x)
#define SCD(x) scanf("%lf",&x)
#define SCS(x) scanf("%s",x)
#define CLR(x) memset(x, 0, sizeof(x))
#define CLRN(x) memset(x, -1, sizeof(x))
#define SCLL(x) scanf("%lld", &x)
#define FOR(i, n) for(int i = 0; i < n; i++)
#define FORR(i, m, n) for(int i = m; i < n; i++)
#define SCl2(m, n) scanf("%d%d",&m, &n)
#define SCI3(m, n, o) scanf("%d%d%d",&m, &n, &o)
#define SCD2(m, n) scanf("%lf%lf",&m,&n)
#define SCD3(m, n, o) scanf("%lftlf%lf",&m,&nl&o)
char ch[600][600];
int m, n, q;
int cnt[600][600], flag[600][600], flag2[600][600], cn;
void dfs(int x, int y)
{
    if (x >= m || y >= n || x < 0 || y < 0) return;
    if (ch[x][y] == '#')return;
    if (flag[x][y]) return;
    if (ch[x][y] == 'C')cn++;
    flag[x][y] = 1;
    dfs(x + 1, y);
    dfs(x, y + 1);
    dfs(x - 1, y);
    dfs(x, y - 1);
}
void asgn(int x, int y, int c)
{
    if (x >= m || y >= n || x < 0 || y < 0) return;
    if (ch[x][y] == '#') return;
    if (flag2[x][y]) return;
    cnt[x][y] = c;
    flag2[x][y] = 1;
    asgn(x + 1, y, c);
    asgn(x, y + 1, c);
    asgn(x - 1, y, c);
    asgn(x, y - 1, c);
}
int main() {
    int t;
    SCI(t);
    FOR(cs, t) {
        CLR(cnt);
        CLR(flag);
        CLR(flag2);
        SCI3(m, n, q);
        char dum;
        scanf("%c", &dum);
        FOR(i, m) {
            FOR(j, n) {
                scanf("%c", &ch[i][j]);
            }
            scanf("%c", &dum);
        }
        FOR(i, m) {
            FOR(j, n) {
                if (!flag[i][j]) {
                    cn = 0;
                    dfs(i, j);
                    asgn(i, j, cn);
                }
            }
        }
        printf("Case %d:\n", cs + 1);
        FOR(i, q) {
            int x, y;
            SCl2(x, y);
            printf("%d\n", cnt[x - 1][y - 1]);
        }
    }
}