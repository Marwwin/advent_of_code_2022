let getInput file_name =
  let read_lines_rec ic =
    let rec read_lines lines = 
      try
        let line = input_line ic in
        read_lines (line :: lines)
      with End_of_file -> List.rev lines
    in read_lines []
  in

  let input_channel = open_in file_name in

  try
    let lines_array = Array.of_list (read_lines_rec input_channel) in
    close_in_noerr input_channel;
    lines_array 
  with e -> 
    close_in_noerr input_channel;
    raise e