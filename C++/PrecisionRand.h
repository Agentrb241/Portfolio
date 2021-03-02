#ifndef PRECISIONRAND_H
#define PRECISIONRAND_H

#include<string>
#include<iostream>
#include <sstream>
#include <iomanip>
#include <ios>
#include<ctime>
#include<cstdlib>
#include "base.h"
#include "Rand.h"

class PrecisionRand : public Rand {
        public:
                PrecisionRand();
                std::string stringify();
};
#endif
