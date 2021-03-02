#ifndef PRECISIONFACTORY_H
#define PRECISIONFACTORY_H

#include "Op.h"
#include "Rand.h"
#include "BaseFactory.h"
#include "PrecisionOp.h"
#include "PrecisionRand.h"

class PrecisionFactory : public BaseFactory {
public:
PrecisionFactory();
Op* createOp(double value);
Rand* createRand();
};
#endif
