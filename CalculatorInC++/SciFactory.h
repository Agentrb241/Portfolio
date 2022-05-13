#ifndef SCIFACTORY_H
#define SCIFACTORY_H

#include "Op.h"
#include "Rand.h"
#include "BaseFactory.h"
#include "SciOp.h"
#include "SciRand.h"

class SciFactory : public BaseFactory {
        public:
                SciFactory();
                Op* createOp(double value);
                Rand* createRand();
};
#endif
