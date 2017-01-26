public class WeightedQU
{
    private int[] id;
    private int[] size;
    
    private int root(int i)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public WeightedQU(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
        
        size = new int[N];
        for (int i = 0; i < N; i++)
        {
            size[i] = 1;
        }
    }
    
    public boolean connected (int p, int q)
    {  
        return root(p) == root(q);
    }
    
    public void union (int p, int q)
    {
        int i = root(p);
        int j = root(q);
        
        if (i == j) return;
        if (size[i] < size[j])
        {
            id[i] = j;
            size[j] += size[i];
        } 
        else
        {
            id[j] = i;
            size[i] += size[j];
        }
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQU qu = new WeightedQU(N);

        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            
            if (!qu.connected(p, q))
            {
                qu.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
