CMAKE_MINIMUM_REQUIRED(VERSION 2.8)

ADD_SUBDIRECTORY(googletest)

SET(CMAKE_CXX_STANDARD 11)

ADD_EXECUTABLE(lab
        main.cpp
        Add.cpp
        Op.cpp
        Divide.cpp
        Mult.cpp
        Rand.cpp
        Sub.cpp
        Pow.cpp
        listCont.cpp
        BS.cpp
        vectorCont.cpp
        SS.cpp
        Ceil.cpp
        Floor.cpp
        Abs.cpp
        Trunc.cpp
        Paren.cpp
        PrecisionOp.cpp
        PrecisionRand.cpp
        SciOp.cpp
        SciRand.cpp
        DoubleFactory.cpp
        SciFactory.cpp
        PrecisionFactory.cpp
        binary_iterator.cpp
        unary_iterator.cpp
	preorder_iterator.cpp
)

ADD_EXECUTABLE(test
        unit_test.cpp
        Add.cpp
        Op.cpp
        Divide.cpp
        Mult.cpp
        Rand.cpp
        Sub.cpp
        Pow.cpp
        listCont.cpp
        BS.cpp
        vectorCont.cpp
        SS.cpp
        Floor.cpp
        Ceil.cpp
        Abs.cpp
        Trunc.cpp
        Paren.cpp
        PrecisionOp.cpp
        PrecisionRand.cpp
        SciOp.cpp
        SciRand.cpp
        DoubleFactory.cpp
        SciFactory.cpp
        PrecisionFactory.cpp
        binary_iterator.cpp
        unary_iterator.cpp
	preorder_iterator.cpp
)

TARGET_LINK_LIBRARIES(test gtest)
TARGET_COMPILE_DEFINITIONS(test PRIVATE gtest_disable_pthreads=ON)
