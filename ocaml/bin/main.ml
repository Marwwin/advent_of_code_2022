open Aoc_utils

let () = 
  let input = getInput "bin/day1_input.txt" in
  Array.fold_left (fun res cur -> 
    match cur with
  | "" -> res
  | n -> Printf.printf "%d +" (int_of_string n)
  ) [] input
  