# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake3

# The command to remove a file.
RM = /usr/bin/cmake3 -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob

# Include any dependencies generated for this target.
include CMakeFiles/test.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/test.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/test.dir/flags.make

CMakeFiles/test.dir/unit_test.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/unit_test.cpp.o: unit_test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/test.dir/unit_test.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/unit_test.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unit_test.cpp

CMakeFiles/test.dir/unit_test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/unit_test.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unit_test.cpp > CMakeFiles/test.dir/unit_test.cpp.i

CMakeFiles/test.dir/unit_test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/unit_test.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unit_test.cpp -o CMakeFiles/test.dir/unit_test.cpp.s

CMakeFiles/test.dir/Add.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Add.cpp.o: Add.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/test.dir/Add.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Add.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Add.cpp

CMakeFiles/test.dir/Add.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Add.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Add.cpp > CMakeFiles/test.dir/Add.cpp.i

CMakeFiles/test.dir/Add.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Add.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Add.cpp -o CMakeFiles/test.dir/Add.cpp.s

CMakeFiles/test.dir/Op.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Op.cpp.o: Op.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/test.dir/Op.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Op.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Op.cpp

CMakeFiles/test.dir/Op.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Op.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Op.cpp > CMakeFiles/test.dir/Op.cpp.i

CMakeFiles/test.dir/Op.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Op.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Op.cpp -o CMakeFiles/test.dir/Op.cpp.s

CMakeFiles/test.dir/Divide.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Divide.cpp.o: Divide.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/test.dir/Divide.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Divide.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Divide.cpp

CMakeFiles/test.dir/Divide.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Divide.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Divide.cpp > CMakeFiles/test.dir/Divide.cpp.i

CMakeFiles/test.dir/Divide.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Divide.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Divide.cpp -o CMakeFiles/test.dir/Divide.cpp.s

CMakeFiles/test.dir/Mult.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Mult.cpp.o: Mult.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/test.dir/Mult.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Mult.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Mult.cpp

CMakeFiles/test.dir/Mult.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Mult.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Mult.cpp > CMakeFiles/test.dir/Mult.cpp.i

CMakeFiles/test.dir/Mult.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Mult.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Mult.cpp -o CMakeFiles/test.dir/Mult.cpp.s

CMakeFiles/test.dir/Rand.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Rand.cpp.o: Rand.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/test.dir/Rand.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Rand.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Rand.cpp

CMakeFiles/test.dir/Rand.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Rand.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Rand.cpp > CMakeFiles/test.dir/Rand.cpp.i

CMakeFiles/test.dir/Rand.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Rand.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Rand.cpp -o CMakeFiles/test.dir/Rand.cpp.s

CMakeFiles/test.dir/Sub.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Sub.cpp.o: Sub.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object CMakeFiles/test.dir/Sub.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Sub.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Sub.cpp

CMakeFiles/test.dir/Sub.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Sub.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Sub.cpp > CMakeFiles/test.dir/Sub.cpp.i

CMakeFiles/test.dir/Sub.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Sub.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Sub.cpp -o CMakeFiles/test.dir/Sub.cpp.s

CMakeFiles/test.dir/Pow.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Pow.cpp.o: Pow.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Building CXX object CMakeFiles/test.dir/Pow.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Pow.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Pow.cpp

CMakeFiles/test.dir/Pow.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Pow.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Pow.cpp > CMakeFiles/test.dir/Pow.cpp.i

CMakeFiles/test.dir/Pow.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Pow.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Pow.cpp -o CMakeFiles/test.dir/Pow.cpp.s

CMakeFiles/test.dir/listCont.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/listCont.cpp.o: listCont.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Building CXX object CMakeFiles/test.dir/listCont.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/listCont.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/listCont.cpp

CMakeFiles/test.dir/listCont.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/listCont.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/listCont.cpp > CMakeFiles/test.dir/listCont.cpp.i

CMakeFiles/test.dir/listCont.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/listCont.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/listCont.cpp -o CMakeFiles/test.dir/listCont.cpp.s

CMakeFiles/test.dir/BS.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/BS.cpp.o: BS.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_10) "Building CXX object CMakeFiles/test.dir/BS.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/BS.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/BS.cpp

CMakeFiles/test.dir/BS.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/BS.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/BS.cpp > CMakeFiles/test.dir/BS.cpp.i

CMakeFiles/test.dir/BS.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/BS.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/BS.cpp -o CMakeFiles/test.dir/BS.cpp.s

CMakeFiles/test.dir/vectorCont.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/vectorCont.cpp.o: vectorCont.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_11) "Building CXX object CMakeFiles/test.dir/vectorCont.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/vectorCont.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/vectorCont.cpp

CMakeFiles/test.dir/vectorCont.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/vectorCont.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/vectorCont.cpp > CMakeFiles/test.dir/vectorCont.cpp.i

CMakeFiles/test.dir/vectorCont.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/vectorCont.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/vectorCont.cpp -o CMakeFiles/test.dir/vectorCont.cpp.s

CMakeFiles/test.dir/SS.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/SS.cpp.o: SS.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_12) "Building CXX object CMakeFiles/test.dir/SS.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/SS.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SS.cpp

CMakeFiles/test.dir/SS.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/SS.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SS.cpp > CMakeFiles/test.dir/SS.cpp.i

CMakeFiles/test.dir/SS.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/SS.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SS.cpp -o CMakeFiles/test.dir/SS.cpp.s

CMakeFiles/test.dir/Floor.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Floor.cpp.o: Floor.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_13) "Building CXX object CMakeFiles/test.dir/Floor.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Floor.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Floor.cpp

CMakeFiles/test.dir/Floor.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Floor.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Floor.cpp > CMakeFiles/test.dir/Floor.cpp.i

CMakeFiles/test.dir/Floor.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Floor.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Floor.cpp -o CMakeFiles/test.dir/Floor.cpp.s

CMakeFiles/test.dir/Ceil.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Ceil.cpp.o: Ceil.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_14) "Building CXX object CMakeFiles/test.dir/Ceil.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Ceil.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Ceil.cpp

CMakeFiles/test.dir/Ceil.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Ceil.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Ceil.cpp > CMakeFiles/test.dir/Ceil.cpp.i

CMakeFiles/test.dir/Ceil.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Ceil.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Ceil.cpp -o CMakeFiles/test.dir/Ceil.cpp.s

CMakeFiles/test.dir/Abs.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Abs.cpp.o: Abs.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_15) "Building CXX object CMakeFiles/test.dir/Abs.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Abs.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Abs.cpp

CMakeFiles/test.dir/Abs.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Abs.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Abs.cpp > CMakeFiles/test.dir/Abs.cpp.i

CMakeFiles/test.dir/Abs.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Abs.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Abs.cpp -o CMakeFiles/test.dir/Abs.cpp.s

CMakeFiles/test.dir/Trunc.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Trunc.cpp.o: Trunc.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_16) "Building CXX object CMakeFiles/test.dir/Trunc.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Trunc.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Trunc.cpp

CMakeFiles/test.dir/Trunc.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Trunc.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Trunc.cpp > CMakeFiles/test.dir/Trunc.cpp.i

CMakeFiles/test.dir/Trunc.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Trunc.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Trunc.cpp -o CMakeFiles/test.dir/Trunc.cpp.s

CMakeFiles/test.dir/Paren.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/Paren.cpp.o: Paren.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_17) "Building CXX object CMakeFiles/test.dir/Paren.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/Paren.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Paren.cpp

CMakeFiles/test.dir/Paren.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/Paren.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Paren.cpp > CMakeFiles/test.dir/Paren.cpp.i

CMakeFiles/test.dir/Paren.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/Paren.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/Paren.cpp -o CMakeFiles/test.dir/Paren.cpp.s

CMakeFiles/test.dir/PrecisionOp.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/PrecisionOp.cpp.o: PrecisionOp.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_18) "Building CXX object CMakeFiles/test.dir/PrecisionOp.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/PrecisionOp.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionOp.cpp

CMakeFiles/test.dir/PrecisionOp.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/PrecisionOp.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionOp.cpp > CMakeFiles/test.dir/PrecisionOp.cpp.i

CMakeFiles/test.dir/PrecisionOp.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/PrecisionOp.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionOp.cpp -o CMakeFiles/test.dir/PrecisionOp.cpp.s

CMakeFiles/test.dir/PrecisionRand.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/PrecisionRand.cpp.o: PrecisionRand.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_19) "Building CXX object CMakeFiles/test.dir/PrecisionRand.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/PrecisionRand.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionRand.cpp

CMakeFiles/test.dir/PrecisionRand.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/PrecisionRand.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionRand.cpp > CMakeFiles/test.dir/PrecisionRand.cpp.i

CMakeFiles/test.dir/PrecisionRand.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/PrecisionRand.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionRand.cpp -o CMakeFiles/test.dir/PrecisionRand.cpp.s

CMakeFiles/test.dir/SciOp.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/SciOp.cpp.o: SciOp.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_20) "Building CXX object CMakeFiles/test.dir/SciOp.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/SciOp.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciOp.cpp

CMakeFiles/test.dir/SciOp.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/SciOp.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciOp.cpp > CMakeFiles/test.dir/SciOp.cpp.i

CMakeFiles/test.dir/SciOp.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/SciOp.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciOp.cpp -o CMakeFiles/test.dir/SciOp.cpp.s

CMakeFiles/test.dir/SciRand.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/SciRand.cpp.o: SciRand.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_21) "Building CXX object CMakeFiles/test.dir/SciRand.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/SciRand.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciRand.cpp

CMakeFiles/test.dir/SciRand.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/SciRand.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciRand.cpp > CMakeFiles/test.dir/SciRand.cpp.i

CMakeFiles/test.dir/SciRand.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/SciRand.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciRand.cpp -o CMakeFiles/test.dir/SciRand.cpp.s

CMakeFiles/test.dir/DoubleFactory.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/DoubleFactory.cpp.o: DoubleFactory.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_22) "Building CXX object CMakeFiles/test.dir/DoubleFactory.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/DoubleFactory.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/DoubleFactory.cpp

CMakeFiles/test.dir/DoubleFactory.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/DoubleFactory.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/DoubleFactory.cpp > CMakeFiles/test.dir/DoubleFactory.cpp.i

CMakeFiles/test.dir/DoubleFactory.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/DoubleFactory.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/DoubleFactory.cpp -o CMakeFiles/test.dir/DoubleFactory.cpp.s

CMakeFiles/test.dir/SciFactory.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/SciFactory.cpp.o: SciFactory.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_23) "Building CXX object CMakeFiles/test.dir/SciFactory.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/SciFactory.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciFactory.cpp

CMakeFiles/test.dir/SciFactory.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/SciFactory.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciFactory.cpp > CMakeFiles/test.dir/SciFactory.cpp.i

CMakeFiles/test.dir/SciFactory.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/SciFactory.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/SciFactory.cpp -o CMakeFiles/test.dir/SciFactory.cpp.s

CMakeFiles/test.dir/PrecisionFactory.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/PrecisionFactory.cpp.o: PrecisionFactory.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_24) "Building CXX object CMakeFiles/test.dir/PrecisionFactory.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/PrecisionFactory.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionFactory.cpp

CMakeFiles/test.dir/PrecisionFactory.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/PrecisionFactory.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionFactory.cpp > CMakeFiles/test.dir/PrecisionFactory.cpp.i

CMakeFiles/test.dir/PrecisionFactory.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/PrecisionFactory.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/PrecisionFactory.cpp -o CMakeFiles/test.dir/PrecisionFactory.cpp.s

CMakeFiles/test.dir/binary_iterator.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/binary_iterator.cpp.o: binary_iterator.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_25) "Building CXX object CMakeFiles/test.dir/binary_iterator.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/binary_iterator.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/binary_iterator.cpp

CMakeFiles/test.dir/binary_iterator.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/binary_iterator.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/binary_iterator.cpp > CMakeFiles/test.dir/binary_iterator.cpp.i

CMakeFiles/test.dir/binary_iterator.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/binary_iterator.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/binary_iterator.cpp -o CMakeFiles/test.dir/binary_iterator.cpp.s

CMakeFiles/test.dir/unary_iterator.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/unary_iterator.cpp.o: unary_iterator.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_26) "Building CXX object CMakeFiles/test.dir/unary_iterator.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/unary_iterator.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unary_iterator.cpp

CMakeFiles/test.dir/unary_iterator.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/unary_iterator.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unary_iterator.cpp > CMakeFiles/test.dir/unary_iterator.cpp.i

CMakeFiles/test.dir/unary_iterator.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/unary_iterator.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/unary_iterator.cpp -o CMakeFiles/test.dir/unary_iterator.cpp.s

CMakeFiles/test.dir/preorder_iterator.cpp.o: CMakeFiles/test.dir/flags.make
CMakeFiles/test.dir/preorder_iterator.cpp.o: preorder_iterator.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_27) "Building CXX object CMakeFiles/test.dir/preorder_iterator.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/test.dir/preorder_iterator.cpp.o -c /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/preorder_iterator.cpp

CMakeFiles/test.dir/preorder_iterator.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/test.dir/preorder_iterator.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/preorder_iterator.cpp > CMakeFiles/test.dir/preorder_iterator.cpp.i

CMakeFiles/test.dir/preorder_iterator.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/test.dir/preorder_iterator.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/preorder_iterator.cpp -o CMakeFiles/test.dir/preorder_iterator.cpp.s

# Object files for target test
test_OBJECTS = \
"CMakeFiles/test.dir/unit_test.cpp.o" \
"CMakeFiles/test.dir/Add.cpp.o" \
"CMakeFiles/test.dir/Op.cpp.o" \
"CMakeFiles/test.dir/Divide.cpp.o" \
"CMakeFiles/test.dir/Mult.cpp.o" \
"CMakeFiles/test.dir/Rand.cpp.o" \
"CMakeFiles/test.dir/Sub.cpp.o" \
"CMakeFiles/test.dir/Pow.cpp.o" \
"CMakeFiles/test.dir/listCont.cpp.o" \
"CMakeFiles/test.dir/BS.cpp.o" \
"CMakeFiles/test.dir/vectorCont.cpp.o" \
"CMakeFiles/test.dir/SS.cpp.o" \
"CMakeFiles/test.dir/Floor.cpp.o" \
"CMakeFiles/test.dir/Ceil.cpp.o" \
"CMakeFiles/test.dir/Abs.cpp.o" \
"CMakeFiles/test.dir/Trunc.cpp.o" \
"CMakeFiles/test.dir/Paren.cpp.o" \
"CMakeFiles/test.dir/PrecisionOp.cpp.o" \
"CMakeFiles/test.dir/PrecisionRand.cpp.o" \
"CMakeFiles/test.dir/SciOp.cpp.o" \
"CMakeFiles/test.dir/SciRand.cpp.o" \
"CMakeFiles/test.dir/DoubleFactory.cpp.o" \
"CMakeFiles/test.dir/SciFactory.cpp.o" \
"CMakeFiles/test.dir/PrecisionFactory.cpp.o" \
"CMakeFiles/test.dir/binary_iterator.cpp.o" \
"CMakeFiles/test.dir/unary_iterator.cpp.o" \
"CMakeFiles/test.dir/preorder_iterator.cpp.o"

# External object files for target test
test_EXTERNAL_OBJECTS =

test: CMakeFiles/test.dir/unit_test.cpp.o
test: CMakeFiles/test.dir/Add.cpp.o
test: CMakeFiles/test.dir/Op.cpp.o
test: CMakeFiles/test.dir/Divide.cpp.o
test: CMakeFiles/test.dir/Mult.cpp.o
test: CMakeFiles/test.dir/Rand.cpp.o
test: CMakeFiles/test.dir/Sub.cpp.o
test: CMakeFiles/test.dir/Pow.cpp.o
test: CMakeFiles/test.dir/listCont.cpp.o
test: CMakeFiles/test.dir/BS.cpp.o
test: CMakeFiles/test.dir/vectorCont.cpp.o
test: CMakeFiles/test.dir/SS.cpp.o
test: CMakeFiles/test.dir/Floor.cpp.o
test: CMakeFiles/test.dir/Ceil.cpp.o
test: CMakeFiles/test.dir/Abs.cpp.o
test: CMakeFiles/test.dir/Trunc.cpp.o
test: CMakeFiles/test.dir/Paren.cpp.o
test: CMakeFiles/test.dir/PrecisionOp.cpp.o
test: CMakeFiles/test.dir/PrecisionRand.cpp.o
test: CMakeFiles/test.dir/SciOp.cpp.o
test: CMakeFiles/test.dir/SciRand.cpp.o
test: CMakeFiles/test.dir/DoubleFactory.cpp.o
test: CMakeFiles/test.dir/SciFactory.cpp.o
test: CMakeFiles/test.dir/PrecisionFactory.cpp.o
test: CMakeFiles/test.dir/binary_iterator.cpp.o
test: CMakeFiles/test.dir/unary_iterator.cpp.o
test: CMakeFiles/test.dir/preorder_iterator.cpp.o
test: CMakeFiles/test.dir/build.make
test: lib/libgtest.a
test: CMakeFiles/test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles --progress-num=$(CMAKE_PROGRESS_28) "Linking CXX executable test"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/test.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/test.dir/build: test

.PHONY : CMakeFiles/test.dir/build

CMakeFiles/test.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/test.dir/cmake_clean.cmake
.PHONY : CMakeFiles/test.dir/clean

CMakeFiles/test.dir/depend:
	cd /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob /home/csmajs/rbadi002/lab-08-visitor-pattern-rohcob/CMakeFiles/test.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/test.dir/depend
