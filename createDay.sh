#!/bin/bash/

main="/src/main/java/com/marwwin/adventofcode2022/$1"
test="/src/test/java/com/marwwin/adventofcode2022/$1"

mkdir $main
mkdir $test

touch "${main}/${1}.java"
touch "${main}/input.txt"
touch "${main}/test.txt"
touch "${test}/${1}Test.java"
