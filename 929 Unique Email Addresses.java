// class Solution {
//     public int numUniqueEmails(String[] emails) {
//         Set<String> emailHash = new HashSet<String>();
        
//         for(String email : emails) {
//             String[] names = email.split("@");
//             String name = checkNames(names[0]) + "@" + names[1];
//             System.out.println(name);
//             emailHash.add(name);   
//         }
        
//         return emailHash.size();
//     }
    
//     private String checkNames(String name) {
//         name = name.replace(".", "");
        
//         for(int i = 0; i < name.length(); i++) {
//             if(name.charAt(i) == '+') {
//                 name = name.substring(0, i);
//                 break;
//             }
//         }
        
//         return name;
//     }
// }

// /**
//  * Faster solution using regex
//  */

// class Solution {
//     public int numUniqueEmails(String[] emails) {
//         Set<String> emailHash = new HashSet<String>();
        
//         for(String email : emails) {
//             String[] names = email.split("@");
//             String[] local = names[0].split("\\+");
//             String name = local[0].replace(".", "") + "@" + names[1];
//             emailHash.add(name);   
//         }
        
//         return emailHash.size();
//     }
// }

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> hash = new HashSet<>();
        
        for(String email : emails) {
            
            String[] names = email.split("@");
            String ans = checkNames(names[0]) + "@" + names[1];
            //System.out.println(ans);
            hash.add(ans);
        }
        
        return hash.size();
    }
    
    private String checkNames(String email) {
        email = email.replace(".", "");
        
        for(int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '+') {
                return email.substring(0, i);
            }
        }
        
        return email;
    }
}