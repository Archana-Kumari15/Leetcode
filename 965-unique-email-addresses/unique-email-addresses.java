class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            String[] split = email.split("@");
            String local = split[0];
            String domain = split[1];

            int plusindex = local.indexOf("+");
                if(plusindex != -1){
                    local = local.substring(0,plusindex);
                }
            local = local.replace("." , "");
            String uniqueEmail = local + "@" + domain;
            set.add(uniqueEmail);
        }
        return set.size();
    }
}