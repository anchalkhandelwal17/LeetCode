// class Solution {
//     public int compareVersion(String version1, String version2) {

//         String[] a = version1.split("\\.");
//         String[] b = version2.split("\\.");

//         int i = 0, j = 0, m = a.length, n = b.length;

//         while (i < m && j < n) {

//             while (i < m && a[i].equals("0"))
//                 i++;
//             while (j < n && b[j].equals("0"))
//                 j++;

//             if (i < m && j < n) {
//                 if (Integer.valueOf(a[i]) > Integer.valueOf(b[j]))
//                     return 1;
//                 else if (Integer.valueOf(a[i]) < Integer.valueOf(b[j]))
//                     return -1;
//             }

//             i++;
//             j++;
//         }

//         while (i < m) {
//             if (Integer.valueOf(a[i]) > 0)
//                 return 1;
//             i++;
//         }
//         while (j < n) {
//             if (Integer.valueOf(b[j]) > 0)
//                 return -1;
//             j++;
//         }
//         return 0;
//     }
// }

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");

        int m = a.length, n = b.length;
        int maxLength = Math.max(m, n);

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < m ? Integer.parseInt(a[i]) : 0;
            int num2 = i < n ? Integer.parseInt(b[i]) : 0;

            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }

        return 0;
    }
}
