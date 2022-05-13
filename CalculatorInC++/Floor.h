#ifndef __FLOOR_H__
#define __FLOOR_H__

#include "Decorator.h"
#include "base.h"


class Floor : public Decorator {
    public:
        /* Constructors */
       Floor(Base* x);

        std::string stringify();
       double evaluate();
};

#endif
