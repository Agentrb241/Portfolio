#include "PrecisionOp.h"

PrecisionOp::PrecisionOp() {}

PrecisionOp::PrecisionOp(double input) {
        this->val = input;
}

std::string PrecisionOp::stringify() {
std::ostringstream Stream;
        Stream << std::setprecision(3) << val;
        return Stream.str();
}
