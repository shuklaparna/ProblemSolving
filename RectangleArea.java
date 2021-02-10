/* RectangleArea
https://leetcode.com/problems/rectangle-area/submissions/
*/

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        if ((E>=C) || (F>= D) || (A>=G) || (B >= H))
		    area = 0;
        else {
            int left1 = Math.max(A, E);
	        int left2 = Math.max(B, F);
	
	        int right1 = Math.min(C, G);
	        int right2 = Math.min(D, H);
	
	        area = (left1-right1) * (left2-right2);
        }
	
	int area1 = Math.abs(C-A) * Math.abs(D-B);
	int area2 = Math.abs(G-E) * Math.abs(H-F);
	
	return (area1 + area2 - area);
    }
}