-module(hw5).
-export([myremoveduplicates/1, elem_helper/2, myintersection/2, mylast/1, myreverse/1, myreverse_helper/2, myreplaceall/3]).

% Problem 1 - myremoveduplicates
elem_helper(Item, []) -> false;
elem_helper(Item, [Y|Ys]) -> (Item == Y) or (elem_helper(Item, Ys)).

myremoveduplicates([]) -> [];
myremoveduplicates([H|T]) -> 
    case hw5:elem_helper(H, T) of
                true ->
                    myremoveduplicates(T);
                false ->
                    [H|myremoveduplicates(T)]
    end.

%  Problem 2 - myintersection
myintersection([], _) -> [];
myintersection(_, []) -> [];
myintersection([H|T], List2) -> 
    case hw5:elem_helper(H, List2) of
        true -> [H|myintersection(T, List2)];
        false -> myintersection(T, List2)
    end.

% Problem 3 - mylast
mylast([]) -> [];
mylast([H | [] ]) -> [H];
mylast([_|T]) -> mylast(T).

% Problem 4 - myreverse
myreverse(List) -> myreverse_helper(List, []).

myreverse_helper([], Reverse) -> Reverse;
myreverse_helper([H|T], Reverse) -> myreverse_helper (T, [H|Reverse]).

% Problem 5 - myreplaceall 
myreplaceall(_, _, []) ->  [];
myreplaceall(To, From, [H|T]) -> 
    if H == From -> [To|myreplaceall(To, From, T)];
    true -> [H|myreplaceall(To, From, T)]
    end.