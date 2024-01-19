# [Silver I] 효율적인 해킹 - 1325 

[문제 링크](https://www.acmicpc.net/problem/1325) 

### 성능 요약

메모리: 303056 KB, 시간: 10924 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 1월 19일 16:34:16

### 문제 설명

<p>해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.</p>

<p>이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.</p>

<p>이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.</p>

### 출력 

 <p>첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.</p>

---

### 💡 정리

- visited 배열을 2차원으로 두어서 더욱 빠르게 해결할 수 있다.
  <details>
   <summary>
    코드 보기 (<a href="https://www.acmicpc.net/source/69472996">출처</a>)
   </summary>
   <div>
    
    ```java
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.ArrayDeque;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Queue;
    import java.util.StringTokenizer;
    
    public class Main {
    
    	public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder sb = new StringBuilder();
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    		for (int i = 0; i <= N; i++)
    			graph.add(new ArrayList<Integer>());
    		for (int i = 0; i < M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int A = Integer.parseInt(st.nextToken());
    			int B = Integer.parseInt(st.nextToken());
    			graph.get(B).add(A);
    		}
    
    		int[] hacking = new int[N + 1];
    		int max = 0;
    		Queue<Integer> que = new ArrayDeque<Integer>();
    		boolean[][] visited = new boolean[N + 1][N + 1];
    
    		for (int i = 1; i <= N; i++) {
    			que.offer(i);
    
    			while (!que.isEmpty()) {
    				int cur = que.poll();
    				if (visited[i][cur])
    					continue;
    				visited[i][cur] = true;
    				hacking[i]++;
    
    				int size = graph.get(cur).size();
    				for (int j = 0; j < size; j++) {
    					if (visited[i][graph.get(cur).get(j)])
    						continue;
    					if (graph.get(cur).get(j) < i) { // 이미 탐색 완료
    						for (int k = 1; k <= N; k++) {
    							if (visited[i][k])
    								continue;
    							if (visited[graph.get(cur).get(j)][k]) {
    								visited[i][k] = true;
    								hacking[i]++;
    							}
    						}
    					} else { // 아직 탐색하지 않은 것
    						que.offer(graph.get(cur).get(j));
    					}
    				}
    			}
    			max = hacking[i] > max ? hacking[i] : max;
    		}
    
    		for (int i = 1; i <= N; i++) {
    			if (max == hacking[i])
    				sb.append(i).append(" ");
    		}
    		System.out.println(sb);
    	}
    
    }    
    ```
    
   </div>
  </details>
