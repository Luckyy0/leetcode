package leetcode.P1452_PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Set<String>> sets = new ArrayList<>();
        for (List<String> list : favoriteCompanies) {
            sets.add(new HashSet<>(list));
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean isSubset = false;
            for (int j = 0; j < n; j++) {
                if (i != j && sets[j].size() >= sets[i].size()) {
                    if (sets[j].containsAll(sets[i])) {
                        isSubset = true;
                        break;
                    }
                }
            }
            if (!isSubset) {
                res.add(i);
            }
        }

        return res;
    }
}
