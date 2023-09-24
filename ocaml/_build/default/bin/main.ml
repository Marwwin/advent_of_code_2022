open Aoc_utils

let () = 
  let input = getInput "bin/day1_input.txt" in
  Array.iter (fun n -> match n with
  | "" -> print_endline ""
  | n -> Printf.printf "%d +" (int_of_string n)
  ) input
  