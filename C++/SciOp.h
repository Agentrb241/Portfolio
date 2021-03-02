#ifndef SCIOP_H
#define SCIOP_H

#include <string>
#include <iostream>
#include <ios>
#include <sstream>
#include "base.h"
#include "Op.h"

class SciOp : public Op {
        public:
                SciOp();
                SciOp(double input);
                std::string stringify();
};

#endif
