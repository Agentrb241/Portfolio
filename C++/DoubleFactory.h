#ifndef DOUBLEFACTORY_H
#define DOUBLEFACTORY_H

#include "Op.h"
#include "Rand.h"
#include "BaseFactory.h"

class DoubleFactory : public BaseFactory {
        public:
                DoubleFactory();
                Op* createOp(double value);
                Rand* createRand();
};
#endif

