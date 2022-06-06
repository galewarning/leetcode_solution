class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] coursesPre = new ArrayList[numCourses];
        for (int i = 0; i < coursesPre.length; i++) {
            coursesPre[i] = new ArrayList<>();
        }
        boolean[] Reached = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            coursesPre[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (coursesPre[i].size() == 0) {
                Reached[i] = true;
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < numCourses; i++) {
                if (Reached[i]) {
                    continue;
                }
                for (int j = 0; j < coursesPre[i].size(); j++) {
                    if ((int)coursesPre[i].get(j) == cur) {
                        coursesPre[i].remove(j);
                    	if (coursesPre[i].size() == 0) {
	                        Reached[i] = true;
	                        q.offer(i);
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (Reached[i] == false) {
                return false;
            }
        }
        
        return true;
    }
}