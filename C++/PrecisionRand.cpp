#include "PrecisionRand.h"

PrecisionRand::PrecisionRand(){
        val = rand() % 100;
}

std::string PrecisionRand::stringify() {
std::ostringstream Stream;
        Stream << std::setprecision(3) << val;
        return Stream.str();
}
