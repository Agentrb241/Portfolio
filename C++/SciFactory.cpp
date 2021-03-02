#include "SciFactory.h"

SciFactory::SciFactory() { }

Op* SciFactory::createOp(double value) {
        Op* opr = new SciOp(value);
        return opr;
}

Rand* SciFactory::createRand() {
        Rand* rand = new SciRand();
        return rand;
}
