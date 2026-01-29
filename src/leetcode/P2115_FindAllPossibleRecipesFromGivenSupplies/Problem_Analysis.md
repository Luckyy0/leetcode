# Problem Analysis: Find All Possible Recipes from Given Supplies

## Problem Description
`recipes`, `ingredients`. `supplies`.
Recipe needs ingredients. Ingredients can be supplies or other recipes.
Topological Sort / Dependency resolution.

## Analysis

1.  **Graph / Kahn's Algorithm**:
    -   Recipes depend on ingredients.
    -   Available set initially `supplies`.
    -   Build graph: `Ingredient -> Recipe`.
    -   `InDegree[Recipe]`: count of missing ingredients.
    -   Queue: Recipes with 0 missing ingredients (all ingredients in supplies).
    -   Wait. Dependencies can be Supplies or Recipes.
    -   If ingredient is Supply, it's satisfied.
    -   If ingredient is Recipe, add edge `OtherRecipe -> ThisRecipe`.
    -   `InDegree`: number of *Recipe* ingredients + *Missing Supply* ingredients?
    -   Actually:
        -   Check if ingredient in supplies. If yes, ignore.
        -   If no:
            -   Is it another recipe?
            -   If yes, edge `Other -> This`. Loop count.
            -   If no (not supply, not recipe), ThisRecipe impossible. (InDegree infinity).
    -   Queue starts with Recipes having inDegree 0 (all ingredients are supplies).
    -   Process queue. When Recipe completed, add to supplies (conceptually), reduce inDegree of dependents.
    -   Add to result list.

## Implementation Details
-   `Map<String, List<String>> adj`.
-   `Map<String, Integer> inDegree`.
-   `Set<String> supplySet`.
-   `Set<String> recipeSet`.
