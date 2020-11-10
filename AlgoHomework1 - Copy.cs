public int BruteForce(int[] points,int n, bool min) {

  //true for min false for max
  int point0 = 0;
  int point1 = 1;
  int num = 0;
  
  if (min) {
    int min = 0;  
    for (int i = 0; i < n; ++i) {
      for (int j = i+1; j < n; ++j) {
	    if (dist(points[i], points[j]) < min){
          min = distance(points[i], points[j]);
        }
	  }
    }
	num = min;
  }
  else {
    int max = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i+1; j < n; ++j) {
	    if (dist(points[i], points[j]) > max)  {
          max = distance(points[i], points[j]);
        }
	  }
    }
	num = max;
  }
  
  int d = distance(points[point0], distance[point1]);
 
  return num;

}

//runtime = O(n^2)

public int FindClosestPair(Object points) {
  if (points.size > 2) {
    left = divideX(points);
    right = divideX(points);

    leftPoints = FindClosestPair(left);
	rightPoints = FindClosestPair(right);
	
	leftDistance = FindClosestPair(left);
	rightDistance = FindClosestPair(right);
	
	points = MergeY(leftPoints, rightPoints);
	distance = min(leftDistance, rightDistance);
	
	strip = OnLine(distance, points);
	
	  foreach (int[] point in strip) {
        Move(distance, points);
	  }
	}
	return distance;
} 
	

	  
//T(n) = 2T(n/2) + O(n)	  
//runtime O(nlogn)
	
  