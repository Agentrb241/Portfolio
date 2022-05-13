#include "SciRand.h"

SciRand::SciRand() : Rand() {

}

std::string SciRand::stringify() {
        std::ostringstream oStream;
        oStream << std::scientific << val;
        return oStream.str();
}

