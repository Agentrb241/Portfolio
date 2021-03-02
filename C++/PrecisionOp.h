#ifndef PRECISIONOP_H
#define PRECISIONOP_H

#include<string>
#include<iostream>
#include <ios>
#include <iomanip>
#include <sstream>
#include "base.h"
#include "Op.h"

class PrecisionOp : public Op {
        public:
                PrecisionOp();
                PrecisionOp(double input);
                std::string stringify();
};

#endif
