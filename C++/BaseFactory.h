#ifndef BASEFACTORY_H
#define BASEFACTORY_H

#include "Op.h"
#include "Rand.h"

class BaseFactory {
        public:
                BaseFactory() {};
                virtual Op* createOp(double value) = 0;
                virtual Rand* createRand() = 0;
};
#endif
