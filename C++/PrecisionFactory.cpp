#include "PrecisionFactory.h"

PrecisionFactory::PrecisionFactory() {
}

Op* PrecisionFactory::createOp(double value) {
Op* newOp = new PrecisionOp(value);
return newOp;
}

Rand* PrecisionFactory::createRand() {
Rand* newRand = new PrecisionRand();
return newRand;
}
