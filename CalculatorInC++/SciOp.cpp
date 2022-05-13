#include "SciOp.h"

SciOp::SciOp() {}

SciOp::SciOp(double input) {
        this->val = input;
}

std::string SciOp::stringify() {
        std::ostringstream oStream;
        oStream << std::scientific << val;
        return oStream.str();
}

