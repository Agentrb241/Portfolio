#include <iostream>
#include "Add.h"
#include "Op.h"
#include "Mult.h"
#include "Divide.h"
#include "Sub.h"
#include "Pow.h"
#include "container.hpp"
#include "vectorCont.h"
#include "listCont.h"
#include "BS.h"
#include "SS.h"
#include "container.hpp"
#include "Decorator.h"
#include "Trunc.h"
#include "Paren.h"
#include "Ceil.h"
#include "Floor.h"
#include "Abs.h"


int main(int argv, char** argc) {
        Op* doubCeil = new Op(409.1);
        std::cout << "ceil(409.1) = ";
        Ceil testCeil(doubCeil);
        std::cout << testCeil.evaluate() << std::endl;
        Op* doubFloor = new Op(230.93);
        std::cout << "floor(230.93) = ";
        Floor testFloor(doubFloor);
        std::cout << testFloor.evaluate() << std::endl;
        Op* absVal = new Op(-2);
        std::cout << "abs(-2) = ";
        Absolute testAbs(absVal);
        std::cout << testAbs.evaluate() << std::endl;



        Op* firstValTrunc = new Op(200);
        Op* secondValTrunc = new Op(4);
        Op* thirdValTrunc = new Op(2);
        Add* add = new Add(firstValTrunc, secondValTrunc);
        Trunc* testTrunc = new Trunc(add);
        Mult mult(testTrunc, thirdValTrunc);
        std::cout << "(200 + 4) * 2 = " << mult.stringify() << std::endl;

        Op* parenVal = new Op(4422);
        Paren parentheses(parenVal);
        std::cout << "4422 shlould now be in parentheses: "
                << parentheses.stringify() << std::endl;
}

