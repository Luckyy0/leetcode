package leetcode.P1108_DefangingAnIPAddress;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
