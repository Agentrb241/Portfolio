#ifndef SCIRAND_H
#define SCIRAND_H

#include<string>
#include<iostream>
#include <ios>
#include <sstream>
#include<ctime>
#include<cstdlib>
#include "base.h"
#include "Rand.h"

class SciRand : public Rand {
public:
        SciRand();
        std::string stringify();
};
#endif
