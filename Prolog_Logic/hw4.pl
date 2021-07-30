% Problem 1
shuffle([H1|[]],[H2|[]],[H1,H2|[]]).
shuffle([H1|T1],[H2|T2],[H1,H2|T3]) :- shuffle(T1,T2,T3).

% Problem 2
double([H|[]], [H, H|[]]).
double([H|T1],[H, H|T2]) :- double(T1, T2).

% Problem 3
member(X,[X|_]).
member(X,[_|T]) :- member(X,T).

no_duplicates([],[]).
no_duplicates([H|T], L) :- member(H,T), no_duplicates(T, L).
no_duplicates([H|T], [H|T1]) :- not(member(H,T)),  no_duplicates(T, T1).

% Problem 4
same_length([],[]).
same_length([_|T1], [_|T2]) :- same_length(T1, T2).

delete(X, [X|T], T).
delete(X, [H|T], [H|S]):- delete(X, T, S).

same_elements([], []).
same_elements([H|T], [H2|T2]) :- member(H, [H2|T2]), same_length([H|T], [H2|T2]), delete(H, [H2|T2], L), same_elements(T, L).