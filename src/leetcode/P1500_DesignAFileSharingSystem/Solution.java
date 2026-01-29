package leetcode.P1500_DesignAFileSharingSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class FileSharing {
    private PriorityQueue<Integer> availableIds;
    private int nextId;
    private Map<Integer, List<Integer>> userChunks; // user -> chunks owned
    // To optimize query, maybe traverse chunks?
    // Map<Integer, Set<Integer>> chunkUsers;

    // Actually, userChunks is good for join/leave.
    // chunkUsers is good for request.
    private Map<Integer, Set<Integer>> chunkUsers;

    public FileSharing(int m) {
        availableIds = new PriorityQueue<>();
        nextId = 1;
        userChunks = new HashMap<>();
        chunkUsers = new HashMap<>();
    }

    public int join(List<Integer> ownedChunks) {
        int id;
        if (!availableIds.isEmpty()) {
            id = availableIds.poll();
        } else {
            id = nextId++;
        }

        userChunks.put(id, new ArrayList<>(ownedChunks));
        for (int chunk : ownedChunks) {
            chunkUsers.computeIfAbsent(chunk, k -> new HashSet<>()).add(id);
        }

        return id;
    }

    public void leave(int userID) {
        if (!userChunks.containsKey(userID))
            return;
        List<Integer> chunks = userChunks.remove(userID);
        for (int chunk : chunks) {
            if (chunkUsers.containsKey(chunk)) {
                chunkUsers.get(chunk).remove(userID);
                if (chunkUsers.get(chunk).isEmpty()) {
                    chunkUsers.remove(chunk);
                }
            }
        }
        availableIds.offer(userID);
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> owners = new ArrayList<>();
        if (chunkUsers.containsKey(chunkID)) {
            owners.addAll(chunkUsers.get(chunkID));
            Collections.sort(owners);
        }

        if (!owners.isEmpty()) {
            if (!userChunks.containsKey(userID)) {
                // Should exist if valid. Or maybe user joined without chunks?
                userChunks.put(userID, new ArrayList<>());
            }
            // Add chunk to requesting user if not already present?
            // "The user with userID requests the file with chunkID... if the user does not
            // own it yet, the user will own it afterwards"
            // We should use Set in userChunks to avoid dups? Or check.
            // Problem says it's a list input but logic suggests Set.
            // Let's check efficienty. `owners` list return sorted.

            // Checking if user already has it
            boolean alreadyHas = chunkUsers.getOrDefault(chunkID, Collections.emptySet()).contains(userID);
            if (!alreadyHas) {
                userChunks.get(userID).add(chunkID);
                chunkUsers.computeIfAbsent(chunkID, k -> new HashSet<>()).add(userID);
            }
        }

        return owners;
    }
}
