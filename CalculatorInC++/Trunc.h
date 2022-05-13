#ifndef __TRUNC_H__
#define __TRUNC_H__

#include "Decorator.h"
#include "base.h"
#include "Op.h"

class Trunc : public Decorator {
    public:
        /* Constructors */
        Trunc();


        Trunc(Base* Base);
        double evaluate();
        std::string stringify();
};

#endif
